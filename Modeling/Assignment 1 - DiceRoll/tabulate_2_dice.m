function [freq, prop] = tabulate_2_dice(Throws)
for k=1:1:12
freq(k)=length(find(Throws==k));
end
prop = 1:12
for i = 1:12
 
prop(i) = freq(i) / length(Throws)
end
end

