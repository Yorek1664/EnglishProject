clear;
close all;
lambda = 10; %taux d'arriv� r/ms
nu = 1 / 0.08; % Taux de d�part
finObs = 100; % temps de fin d'observation


arrive = arrive(lambda,finObs);
depart = depart(nu,arrive,finObs);

plot(arrive);
hold on;
plot(depart, 'color', 'red');
legend('arrives','departs');
hold off;

%A v�rifier 
tAttTheorique = lambda / (nu * ( nu - lambda));
tAtt = CalculTpsAtt(arrive, depart);

tMoySerTheorique = 1 / nu;
tMoySer = CalculTpsMoySer(arrive,depart);

txOccTheorique = lambda / nu;
txOcc = CalculTxOcc(arrive,depart,finObs);

NbMoyenFilAtt = (lambda * lambda) /  (nu * (nu-lambda));
NbMoyenSer = lambda / nu;
NbMoyenUtilTheorique = NbMoyenFilAtt + NbMoyenSer;
NbMoyenUti = CalculNbMoyenUti(arrive,depart,finObs);
%step(arrive,depart,finObs);