% Clear workspace
clear;

% Load flights data from CSV file
flights = readtable("Flights.csv");

% Remove rows with missing data in 'Day' column
flights_cleaned = flights(~isnan(flights.Day), :);

% Check size of cleaned data
size = size(flights_cleaned);

% Convert origin and destination columns from cell arrays to string arrays
flights_cleaned.origin = string(flights_cleaned.origin);
flights_cleaned.dest = string(flights_cleaned.dest);

% Check number of missing values in 'dep_delay' column
missing_values = summary(flights_cleaned);

% Remove rows with missing values in 'dep_delay' column
flights_filtered = flights_cleaned(~isnan(flights_cleaned.dep_delay), :);

% Calculate the difference in the number of rows between the two tables
rows_difference = height(flights_cleaned) - height(flights_filtered);

% Filter out rows with departure delay greater than 120 minutes
flights_final = flights_filtered(flights_filtered.dep_delay <= 120,:);

% Calculate average delay per month
% Group flights by month
[groups, month] = findgroups(flights_final.Month);

% Calculate average delay per month
average_delay_month = splitapply(@mean, flights_final.dep_delay, groups);

% Create table of average delay by month
table_month = table(month, average_delay_month);

% Plot graph of average delay by month
%plot(table_month.month, table_month.average_delay_month, '-o');
%title("Average Delay By Month");

% Calculate average delay per hour
% Group flights by hour
[groups, hour] = findgroups(flights_final.hour);

% Calculate average delay per hour
average_delay_hour = splitapply(@mean, flights_final.dep_delay, groups);

% Create table of average delay by hour
table_hour = table (hour, average_delay_hour);

% Plot graph of average delay by hour
%plot(table_hour.hour, table_hour.average_delay_hour, '-o');
%title("Average Delay By Hour of the Day");

%Average Delay by Month and Origin
%Group by origin, Month
[G, origin, Month] = findgroups(flights_final.origin, flights_final.Month);

%Average Delay
AvrDelayMonthOrigin = splitapply(@mean, flights_final.dep_delay, G);

%Table
res3 = table(Month, origin, AvrDelayMonthOrigin);

%Create pivot table
%pivot_table = pivot(res3, 'Month', 'origin', 'AvrDelayMonthOrigin');

%Display pivot table
%disp(pivot_table);

U = unstack(res3, 'AvrDelayMonthOrigin', 'origin');

disp(U)

plot(U.Month, U.JFK, '-o');
title("JFK");

plot(U.Month, U.EWR, '-o');
title("EWR");

plot(U.Month, U.LGA, '-o');
title("LGA");
