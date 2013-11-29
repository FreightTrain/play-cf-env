# play-cf-env

## Introduction

## Setup

### Install the CF command line tools

To use Cloud Foundry you will need to install the Cloud Foundry command line toolset.

1. Download the CLI binary for your system

    * [CF CLI binary for OSX (x64)](http://go-cli.s3.amazonaws.com/gcf-darwin-amd64.tgz)   
    * [CF CLI binary for Linux (x64)](http://go-cli.s3.amazonaws.com/gcf-linux-amd64.tgz)
    * [CF CLI binary for Windows (x64)](http://go-cli.s3.amazonaws.com/gcf-windows-amd64.zip)

2. You will need to uncompress the downloaded binay and make sure the **gcf** binary is in your $PATH
3. Test your installation


		tastle@tastle-mac $ gcf
		NAME:
		   gcf - A command line tool to interact with Cloud Foundry
		
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


