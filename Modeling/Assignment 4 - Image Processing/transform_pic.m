function [eng1_gs_inv] = transform_pic(eng1_gs)
% Converts a 255 color code to 0, 254 to 1, and so on, using the equation of a line

% Convert the output image to uint8 data type
eng1_gs_inv = uint8(255) - eng1_gs;
end
