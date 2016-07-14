/**
 * Created by xhans on 2016/7/14 0014.
 */
show = {print it}
square_root = {Math.sqrt(it)}

def please(action) {
    [the: { what ->
        [of: {n -> action(what(n))}]
    }]
}

please show the square_root of 100
