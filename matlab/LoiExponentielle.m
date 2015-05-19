function[moy, v] = LoiExponentielle(lambda, n)

  %Génération de la variable aléatoire
  for i=1:n
    u = rand;
    X(i) = - (log(u) / lambda);
  end
  
  %Calcul de la moyenne
  moy = 0;
  for i=1:n
      moy = moy + X(i);
  end
    moy = moy / n;
  
  %Calcul de la variance
  v = var(X);
  