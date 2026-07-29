/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {

    let c = init;

    return{
        increment : function(){
            return ++c;
        },

        decrement : function(){
            return --c;
        },

        reset : function(){
             c = init;
            return c;
        }

    }
    
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */