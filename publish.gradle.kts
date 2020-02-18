// Copyright (C) 2017 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

plugins.apply("maven-publish")


if (project.extra.has("exoplayerPublishEnabled")
        && project.extra.get("exoplayerPublishEnabled") == true) {
//    apply plugin: 'bintray-release'
//    publish {
//        artifactId = releaseArtifact
//        desc = releaseDescription
//        publishVersion = releaseVersion
//        repoName = getBintrayRepo()
//        userOrg = 'google'
//        groupId = 'com.google.android.exoplayer'
//        website = 'https://github.com/google/ExoPlayer'
//    }
    configure<PublishingExtension> {
        repositories {
            maven {
                url = uri("$buildDir/repo")
            }
        }
        publications {
            register("mavenJava", MavenPublication::class) {
                groupId = "com.google.android.exoplayer"
                artifactId =  project.extra.get("releaseArtifact") as String
                version = (project.extra.get("releaseVersion") as String) + "-wave"
                artifact = "$buildDir/outputs/aar/${project.name}-debug.aar"
//                from(components["java"])
//                artifact(sourcesJar.get())
            }
        }
    }
//    publishing {
//        publications {
//            library(MavenPublication) {
//                groupId 'com.google.android.exoplayer'
//                artifactId releaseArtifact
//                version releaseVersion
//                artifact("$buildDir/outputs/aar/${project.name}-debug.aar")
//            }
//        }
//        repositories {
//            maven {
//                url "$buildDir/repo"
//            }
//        }
//    }
}
