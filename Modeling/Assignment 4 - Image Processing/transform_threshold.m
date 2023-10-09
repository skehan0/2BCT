function [eng1_gs_bin] = transform_threshold(eng1_gs, threshold)

% Apply the threshold operation to the grayscale image
eng1_gs_bin = eng1_gs >= threshold;

end
