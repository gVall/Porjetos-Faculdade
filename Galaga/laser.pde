class Municao
{
  int x, y;
  
  Municao(int xpos, int ypos)
  {
    x = xpos + gridsize / 2 + 1;
    y = ypos;
  }
  
  void draw()
  {
    fill(0, 255, 0);
    rect(x, y, pixelsize, pixelsize);
    y -= pixelsize * 2;
  }
}

class MunicaoBoss
{
  int x, y;
  
  MunicaoBoss(int xpos, int ypos)
  {
    x = xpos + gridsize/2;
    y = ypos - 450;
  }
  
  void draw()
  {
    fill(255, 0, 0);
    rect(x, -y, pixelsize + 2, pixelsize + 4);
    y -= pixelsize * 3;
  }
}

class Morte
{
  int x, y;
  int n = 0;
  int p = 5;
  float i = 1;
  int l, h;
  
  Morte(int xpos, int ypos) 
  {
    x = xpos;
    y = ypos;
    h = 60;
    l = 60;
  }
  
  void BOOOM(int cor) 
  {
    if (cor == 1)
      fill(200, 0, 0);
    if (cor == 2)
      fill(0, 228, 251);
      
    int delay = 0;
    for (int i = 0; i < 50; i++)
    {
      if (delay <= 10)
      {
        ellipse(x, y, h, l);
        h += 10;
        l += 10;
      }
      else 
      {
        p += 5;
        ellipse(x - p, y - p, h/i, l/i);
        ellipse(x - p, y + p, h/i, l/i);
        ellipse(x + p, y - p, h/i, l/i);
        ellipse(x + p, y + p, h/i, l/i);
      }
      delay += 2;
    }
  }
}
