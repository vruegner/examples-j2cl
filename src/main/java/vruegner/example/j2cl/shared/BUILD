load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_library")
load("@rules_java//java:defs.bzl", "java_library")

#
# j2cl shared library for the client package
#
j2cl_library(
    name = "shared-lib-j2cl",
    visibility = ["//src/main/java/vruegner/example/j2cl/client:__subpackages__"],
    srcs = [
        "Location.java",
    ],
    deps = [
        "@com_google_j2cl//:jsinterop-annotations-j2cl",
    ],
)

#
# java library for the server package
#
java_library(
    name = "shared-lib-java",
    visibility = ["//src/main/java/vruegner/example/j2cl/server:__subpackages__"],
    srcs = [
        "Location.java",
    ],
    deps = [
        "@com_google_j2cl//:jsinterop-annotations",
    ],
)