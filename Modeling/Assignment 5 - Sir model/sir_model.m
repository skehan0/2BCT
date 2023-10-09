function [t,y] = sir_model(time_vec, init_vec, c, i, alpha, beta, gamma)

[t,y] = ode45(@SIR_ode, time_vec, init_vec);

    function dydt = SIR_ode(~, y)
        S = y(1);
        I = y(2);
        R = y(3);
        H = y(4);
        RH = y(5);
        N = S + I + R + H + RH;

        dS = -c*S*(I/N)*i;
        dI = c*S*(I/N)*i - alpha*I;
        dR = alpha*I - beta*R;
        dH = beta*R - gamma*H;
        dRH = gamma*H;

        dydt = [dS; dI; dR; dH; dRH];
    end

end