void Boss()
{ 
  for (int i = 0; i < municaoBoos.size(); i++)
  {
    MunicaoBoss MunicaoBoss = (MunicaoBoss) municaoBoos.get(i);
    MunicaoBoss.draw();
  }

  for (int i = 0; i < chefe.size(); i++)
  {
    Boss Boss = (Boss) chefe.get(i);
    fill(236, 237, 0);
    textFont(f);
    text("Escudos Boss: " + String.valueOf(Boss.vidaBoss) + "0%", (width / PI + 250), 40);
    text("Escudos Nave: " + String.valueOf(Escudo) + "0%", (width / PI - 130), 40);
   
    if (Boss.outside() == true)
    {
      direcao *= (-1);
      break;
    }
  }

  for (int i = 0; i < chefe.size(); i++)
  {
    Boss Boss = (Boss) chefe.get(i);
    if (!Boss.alive())
    {
      animacao = new Morte(Boss.x, Boss.y);
      animacao.BOOOM(1);
      chefe.remove(i);
    } 
    else
    {
      Boss.draw();
    }
  }
  parede = false;
}

void drawScore()
{
  fill(236, 237, 0);
  textFont(f);
  text("Pontuação: " + String.valueOf(score), 10, 40);
}

void createinimigos()
{
  for (int i = 0; i < width/gridsize/1.5; i++)
  {
    for (int j = 0; j < 5; j++) 
    {
      inimigos.add(new Inimigo(i*gridsize, j*gridsize + 70));
    }
  }
}

void createBoss()
{
  chefe.add(new Boss(gridsize, gridsize + 70));
}
