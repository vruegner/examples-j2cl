workspace(name = "examples-j2cl")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

#
# Load maven repository
#
RULES_JVM_EXTERNAL_TAG = "3.3"
RULES_JVM_EXTERNAL_SHA = "d85951a92c0908c80bd8551002d66cb23c3434409c814179c0ff026b53544dab"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

#
# Load maven dependencies
#
maven_install(
    artifacts = [
	"javax.servlet:javax.servlet-api:4.0.1",
	"javax.ws.rs:javax.ws.rs-api:2.1.1",
        "org.glassfish.jersey.containers:jersey-container-servlet-core:2.32",
        "org.glassfish.jersey.core:jersey-server:2.32",
	"org.glassfish.jersey.core:jersey-common:2.32",
	"org.glassfish.jersey.inject:jersey-hk2:2.32",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)

#
# Load j2cl repository
#
http_archive(
    name = "com_google_j2cl",
    strip_prefix = "j2cl-master",
    url = "https://github.com/google/j2cl/archive/master.zip",
)

load("@com_google_j2cl//build_defs:repository.bzl", "load_j2cl_repo_deps")
load_j2cl_repo_deps()

load("@com_google_j2cl//build_defs:rules.bzl", "setup_j2cl_workspace")
setup_j2cl_workspace()

#
# Load elemental2 repository
#
http_archive(
    name = "com_google_elemental2",
    strip_prefix = "elemental2-1.1.0",
    url = "https://github.com/google/elemental2/archive/1.1.0.zip",
)

load("@com_google_elemental2//build_defs:repository.bzl", "load_elemental2_repo_deps")
load_elemental2_repo_deps()

load("@com_google_elemental2//build_defs:workspace.bzl", "setup_elemental2_workspace")
setup_elemental2_workspace()
