function [eng1_gs] = pic2grayscale(eng1)
% Convert RGB image to grayscale using NTSC Standard transformation

% Define transformation matrix for NTSC Standard
ntsc_transform = [0.2989, 0.5870, 0.1140];

% Convert the input image to a 2D array and multiply with the transformation matrix
gray_image = double(eng1(:,:,1)) * ntsc_transform(1) + ...
    double(eng1(:,:,2)) * ntsc_transform(2) + ...
    double(eng1(:,:,3)) * ntsc_transform(3);

% Convert the output to uint8 data type
eng1_gs = uint8(gray_image);
end
