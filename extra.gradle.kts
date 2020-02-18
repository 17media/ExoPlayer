plugins.apply("maven-publish")
allprojects {
    extra.apply { set("exoplayerPublishEnabled", true) }
}