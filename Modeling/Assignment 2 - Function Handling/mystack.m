function [push,pop,peek] = mystack()

push = @mystack_push;
pop = @mystack_pop;
peek = @mystack_peek;
end

function stack = mystack_push(stack, value)
    stack = [stack, value];
end

function stack = mystack_pop(stack)
    stack = stack(1:end-1);
end
 
function value = mystack_peek(stack)
    value = stack(end);
end