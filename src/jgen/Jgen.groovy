package jgen
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.runtime.RuntimeConstants
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader

/**
 * Created by xhans on 2016/7/14 0014.
 */
class Jgen {
    def ve
    def template

    Jgen(template) {
        ve = new VelocityEngine()
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath")
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init()

        this.template = ve.getTemplate(template)
    }

    def generate(ctx) {
        def sw = new StringWriter()
        template.merge(ctx, sw)
        sw.toString()
    }

}
