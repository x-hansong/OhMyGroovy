package jgen
import org.apache.velocity.VelocityContext

/**
 * Created by hansong.xhs on 2016/7/15.
 */
@Grapes(
        @Grab(group = 'org.apache.velocity', module = 'velocity', version = '1.7')
)
static void main(args) {

    def ctx = new VelocityContext()

    ctx.put("name", "velocity")
    ctx.put("date", (new Date()).toString())
    ctx.put("list", [1, 2])

    println new Jgen("templates/Hello.vm").generate(ctx)
}
