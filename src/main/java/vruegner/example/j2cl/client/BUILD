load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_application", "j2cl_library")

j2cl_library(
    name = "client-lib-j2cl",
    srcs = [
        "Client.java",
	"LocationWC.java",
	"app.js",
    ],
    deps = [
	"@com_google_jsinterop_base//:jsinterop-base-j2cl",
        "@com_google_j2cl//:jsinterop-annotations-j2cl",
	"@com_google_elemental2//:elemental2-core-j2cl",
	"@com_google_elemental2//:elemental2-dom-j2cl",
	"@com_google_elemental2//:elemental2-promise-j2cl",
	"//src/main/java/vruegner/example/j2cl/shared:shared-lib-j2cl"
    ],
)

j2cl_application(
    name = "client-app",
    entry_points = ["vruegner.example.j2cl.client.app"],
    deps = [":client-lib-j2cl"],
)