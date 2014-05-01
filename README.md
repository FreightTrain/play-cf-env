# play-cf-env

## Introduction

This is a Cloud Foundry sample application to display the environment details of a Play! Framework Application.

## Setup

### Install the CF command line tools

To use Cloud Foundry you will need to install the Cloud Foundry command line toolset.

1. Download the CLI binary for your system

    * [CF CLI Installers](https://github.com/cloudfoundry/cli#installers)   

2. Test your installation


		tastle@tastle-mac $ ccf
		NAME:
		   cf - A command line tool to interact with Cloud Foundry
		
		USAGE:
		   [environment variables] gcf [global options] command [arguments...] [command options]
		
		VERSION:
		   6.0.0.rc1-12816c9566
		
		GETTING STARTED:
		   login, l                           Log user in
		   logout, lo                         Log user out
		   passwd, pw                         Change user password
		   target, t                          Set or view the targeted org or space
		
		   api                                Set or view target api url
		   auth                               Authenticate user non-interactively
		
	    ...


If you are curious and want to know more about the CLI you can [view the source on Github]((https://github.com/cloudfoundry/cli#cloud-foundry-cli-written-in-go-).


### Install Play

1. [Download the Play framework](http://www.playframework.com/download)
2. Uncompress Play and make sure the **play** binary is in your $PATH
3. Test your installation

		tastle@ontinue-mac play-cf-env $ play
		       _            _
		 _ __ | | __ _ _  _| |
		| '_ \| |/ _' | || |_|
		|  __/|_|\____|\__ (_)
		|_|            |__/
		
		play! 2.1.0 (using Java 1.7.0_40 and Scala 2.10.0), http://www.playframework.org
		...

## Running the project

1. Login to the CloudFoundry server using GCF

        $ cf login		

2. Push your application to Cloud Foundry

	    $ cd play-cf-env
	    $ play dist
	    $ cf push play-cf-env -p dist/play-cf-env-1.0-SNAPSHOT.zip


## Editing the project

1. Generate the IntelliJ Idea project

	    $ cd play-cf-env
	    $ play idea with-sources=yes

2. Open IntelliJ Idea
3. Open the generated project in IntelliJ <br>
   File -> Open -> [Select the play-cf-env directory]
   
   
   


