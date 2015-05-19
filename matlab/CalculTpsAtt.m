function[tAtt] = CalculTpsAtt(arrive,depart)

n = size(arrive);
m = size(depart);

% Calcul du temps d'attente
continu = 1;
i = 1;
somme = 0;
while continu == 1
    j = i+1;
    %On v�rifie qu'on ne d�passe pas la taille des tableaux
    if (i >= n(2))
        continu = 0;
    end;
    if ( j >= m(2))
       continu = 0;
    end;
    if (continu == 1)
        %On prend le temps d'arriv� du client suivant
        tps_arrive_suiv = arrive(j);
        %On prend le temps de d�part du client courant
        tps_depart = depart(i);
        %On calcule la diff�rence
        diff = tps_depart - tps_arrive_suiv;
        if(diff >= 0)
            somme = somme + diff;
        end;
        i = i + 1;
    end;
end;

tAtt = somme / i;
