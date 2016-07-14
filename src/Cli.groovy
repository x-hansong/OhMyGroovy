

/**
 * Created by xhans on 2016/7/13 0013.
 */
def cmdline = new CliBuilder(usage: "Cli -[ch] ")
cmdline.with {
    h longOpt:'help', required:false, 'show usage';
    d longOpt: 'destFile', argName: 'destFile', optionalArg: true, args: 1,
            'jar destination filename';
    m longOpt: 'mainclass', argName: 'mainclass', required: true, args: 1,
            'fully name of main class';
    c longOpt: 'groovyc', required: false, 'Run groovyc';
    s longOpt: 'sourcepath', argName: 'sourcepath', required: true, args: 1,
            'fully path to the mainclass. Must be specified with .groovy file path when -c option used.';
}
def opt = cmdline.parse(args)
if (!opt) {
    return
}
if (opt.h) {
    cmdline.usage()
    return
}
