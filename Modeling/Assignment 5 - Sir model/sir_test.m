contacts = linspace(3, 8, 20);
infectivity = 0.125;
alpha = 0.25;
beta = 0.02;
gamma = 0.10;

% Set up time vector and initial conditions
time_vec = 0:0.25:100;
init_vec = [9999, 1, 0, 0, 0];

out_infected = zeros(length(time_vec), length(contacts));
out_in_hospital = zeros(length(time_vec), length(contacts));

% Run the model for each value of contacts
for i = 1:length(contacts)
    [t, y] = sir_model(time_vec, init_vec, contacts(i), infectivity, alpha, beta, gamma);
    out_infected(:, i) = y(:, 2); % Infected stock
    out_in_hospital(:, i) = y(:, 4); % Hospitalised stock
end

% Plot the results
subplot(3,1,1);
plot(time_vec, out_infected);
title('Infected Stock');
grid on;

subplot(3,1,2);
plot(time_vec,out_in_hospital);
title('People in Hospital');
grid on;

subplot(3,1,3);
scatter(contacts, max(out_in_hospital));
title('Contacts v Peak in Hospital');
grid on;