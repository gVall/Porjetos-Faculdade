ArrayList<PVector> estrelas = new ArrayList<PVector>();
ArrayList municaoBoos = new ArrayList();
ArrayList inimigos = new ArrayList();
ArrayList municao = new ArrayList();
ArrayList chefe = new ArrayList();
boolean parede = false;
int pixelsize = 4;
Meteorito chuva;
int direcao = 1;
Morte animacao;
int Escudo = 0;
Player player;
int score = 0;
int Num = 100;
int gridsize;
int P1 = 10;
int P2 = 15;
int Desloc;
PImage Img;
int index;
PFont f;

void setup()
{
  f = createFont("Arial", 36, true);
  Img = loadImage("Asteroide.png");
  gridsize = pixelsize * 7 + 10;
  chuva = new Meteorito();
  player = new Player();
  size(1400, 800, P3D);
  textureMode(NORMAL);
  createinimigos();
  createBoss();
}

void draw()
{
  background(0);
  
  chuva.draw();
  
  noStroke();
  
  cometa(1);
  
  drawScore();
  
  if (score >= 6000)
  {
    cometa(2);
    Boss();
  }
  
  player.draw();
  
  if (!player.alive())
  {
    fill(147, 0, 0);
    textFont(createFont("Arial", 60, true));
    text("GAME OVER", width/3, height/2);
    animacao = new Morte(player.x, player.y);
    animacao.BOOOM(2);
    stop();
  }
  else
  {
    Escudo = player.vidaPlayer;
  }
  
  if (score >= 6800)
  {
    fill(140, 0, 255);
    textFont(createFont("Arial", 60, true));
    text("WIN", width/2.25, height/2);
    stop();
  }

  for (int i = 0; i < municao.size(); i++)
  {
    Municao Municao = (Municao) municao.get(i);
    Municao.draw();
  }

  for (int i = 0; i < inimigos.size(); i++)
  {
    Inimigo Inimigo = (Inimigo) inimigos.get(i);
    if (Inimigo.y >= (height - 60))
    {
      fill(147, 0, 0);
      textFont(createFont("Arial", 60, true));
      text("GAME OVER", width/2.5, height/2);
      stop();
    }
    if (Inimigo.outside() == true)
    {
      direcao *= (-1);
      parede = true;
      break;
    }
  }

  for (int i = 0; i < inimigos.size(); i++)
  {
    Inimigo Inimigo = (Inimigo) inimigos.get(i);
    if (!Inimigo.alive())
    {
      animacao = new Morte(Inimigo.x, Inimigo.y);
      animacao.BOOOM(1);
      inimigos.remove(i);
    } else
    {
      Inimigo.draw();
    }
  }
  
  parede = false;
}
