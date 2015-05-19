function[tMoySer] = CalculTpsMoySer(arrive,depart)

n = size(arrive);
m = size(depart);

% Calcul du temps moyen de service
continu = 1;
i = 2;
%On fait la 1ere itération
somme = depart(1) - arrive(1);
while continu == 1
    j = i - 1;
    if (i >= n(2))
        continu = 0;
    end;
    if ( i >= m(2))
       continu = 0;
    end;
    if (continu == 1)
        %On prend le temps de départ du client courant
        tps_arrive = arrive(i);
        %On prend le temps de départ du client courant
        tps_depart = depart(i);
        %Le temps de départ pour déduire le temps d'attente
        tps_depart_prec = depart(j);
        %Le client a attendu, on soustrait ce temps d'attente
        if(tps_depart_prec > tps_arrive)
            tps_att = tps_depart_prec - tps_arrive;
            diff = (tps_depart - tps_arrive) - tps_att;
        else
            %On calcule la différence
            diff = tps_depart - tps_arrive;
        end;
        somme = somme + diff;
        i = i + 1;
    end;
end;
disp(somme)
tMoySer = somme / i;
