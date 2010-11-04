Each subdirectory in this directory (with the exception of "docs") represents a software project.  The projects are as follows:

Project Name        Dependencies               Purpose
===============================================================================
api                                            public API for BSJ
build-tools                                    provide BSJ-specific build utils
devutils            api, generator, parser,
                    utils                      developer utilities
generator           api, parser, utils         BSJ compiler implementation
parser              api, utils                 BSJ parser implementation
plugin                                         BSJ Eclipse plugin
source-generator    utils                      generates source for BSJ projects
stdlib              api, utils                 BSJ user utilities
tests               api, generator, parser,
                      stdlib, utils            JUnit testing
utils               api                        Utils common to BSJ projects

In order to build the projects in Eclipse, you will need to have the ANTLR IDE
plugin installed (http://antlrv3ide.sourceforge.net/).
