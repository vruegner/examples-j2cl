def _prepare_file(ctx, output, target_file):

        output_file = ctx.actions.declare_file(output)

        ctx.actions.symlink(
            output = output_file,
            target_file = target_file,
        )

        return output_file

def _webapp_impl(ctx):

    files = []

    for file in ctx.files.srcs:
        files.append(_prepare_file(ctx, file.short_path[len(ctx.label.package) + 1:], file))

    for providers in ctx.attr.deps:
        if JavaInfo in providers:
             for file in providers[JavaInfo].transitive_runtime_jars.to_list():
                 files.append(_prepare_file(ctx, "WEB-INF/lib/" + file.basename, file))

    return [DefaultInfo(runfiles = ctx.runfiles(files = files))]

webapp = rule(

    implementation = _webapp_impl,

    attrs = {
        "srcs": attr.label_list(allow_files = True),
        "deps": attr.label_list(),
    },

)