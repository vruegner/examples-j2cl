load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
	name = "server-lib",
	visibility = ["//webapp:__pkg__"],
	srcs = [
		"RequestHandler.java",
		"RestApplication.java",
		"RestServletContainer.java",
	],
	deps = [
		"@maven//:javax_servlet_javax_servlet_api",
		"@maven//:javax_ws_rs_javax_ws_rs_api",
		"@maven//:org_glassfish_jersey_containers_jersey_container_servlet_core",
		"@maven//:org_glassfish_jersey_core_jersey_server",
		"@maven//:org_glassfish_jersey_core_jersey_common",
		"@maven//:org_glassfish_jersey_inject_jersey_hk2",
		"//src/main/java/vruegner/example/j2cl/shared:shared-lib-java",
	],
)

