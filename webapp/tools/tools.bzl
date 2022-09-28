def _war_impl(ctx):

    files_to_zip = []
    inputs = []
    output_file_war = ctx.actions.declare_file(ctx.attr.war_name)

    inputs += ctx.files.data
    for file in ctx.files.data:
        files_to_zip.append(file.short_path[len(ctx.attr.data_dir) + 1:] + "=" + file.path)

    for providers in ctx.attr.deps:
        if JavaInfo in providers:
            inputs += providers[JavaInfo].transitive_runtime_jars.to_list()
            for dep in providers[JavaInfo].transitive_runtime_jars.to_list():
                files_to_zip.append("WEB-INF/lib/" + dep.basename + "=" + dep.path)

    arguments = ["c", output_file_war.path] + files_to_zip

    ctx.actions.run(
        inputs = inputs,
        outputs = [output_file_war],
        executable = ctx.executable._zipper,
        arguments = arguments,
    )

    return [DefaultInfo(files = depset([output_file_war]))]

war = rule(
    implementation = _war_impl,
    attrs = {
        "war_name": attr.string(
            mandatory = True,
        ),
        "data": attr.label_list(
            allow_files = True,
            mandatory = True,
        ),
        "data_dir": attr.string(
            mandatory = True,
        ),
        "deps": attr.label_list(
        ),
        "_zipper": attr.label(
            default = Label("@bazel_tools//tools/zip:zipper"),
            executable = True,
            cfg = "host",
        ),
    },
)
