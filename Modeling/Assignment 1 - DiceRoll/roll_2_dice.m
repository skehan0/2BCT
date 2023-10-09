function sum = roll_2_dice(N, seed)
rng(seed);
r = randi([1,6], [N,2]);
sum = r(:,1) + r(:,2);
end