import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.runtime.RuntimeConstants
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader

/**
 * Created by xhans on 2016/7/14 0014.
 */
@Grapes(
        @Grab(group='org.apache.velocity', module='velocity', version='1.7')
)
static void main(args) {
    def ve = new VelocityEngine()
    ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath")
    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

    ve.init()

    def t = ve.getTemplate("templates/Hello.vm")
    def ctx = new VelocityContext()

    ctx.put("name", "velocity")
    ctx.put("date", (new Date()).toString())
    ctx.put("list", [1, 2])

    def sw = new StringWriter()

    t.merge(ctx, sw)

    println sw.toString()
}
