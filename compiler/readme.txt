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

***** NOTE:
    Due to bugs which appear in official releases of JDK 1.6, it is probably not
possible to use the ANT build scripts to compile the BSJ compiler at this time.
Eclipse's compiler is not suffering these problems.  Even if it were possible to
use the JDK 1.6 compiler, these ANT scripts do not properly generate the BSJ
parser from the ANTLR grammar.
    For the time being, BSJ is being developed within Eclipse.  Importing the
projects in these directories into a workspace should be sufficient to start a
build, althouh you may need to clean and rebuild a couple times due to some
peculiarities we have seen with ANTLR IDE.  Distributions can be exported from
Eclipse as well.
    Our intention is to support a headless build eventually and it shouldn't be
a lot of work to do so; we just haven't had the time.