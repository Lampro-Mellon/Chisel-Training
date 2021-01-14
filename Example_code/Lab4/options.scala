                       Selected Tester Options
                       -----------------------

-tbn, --backend-name <firrtl|treadle|verilator|ivl|vcs>
                     backend to use with tester, default is treadle

-tiv, --is-verbose   set verbose flag on PeekPokeTesters, default is false

-twffn, --wave-form-file-name <value>   
                     wave form file name
 
-tts, --test-seed <value>
                     provides a seed for random number generator
 
-tgvo, --generate-vcd-output <value>
                     set this flag to "on" or "off", otherwise it defaults to on 
                     for verilator, off for scala backends

-td <target-directory>, --target-dir <target-directory>
                     defines a work directory for intermediate files, default is     
                     current directory