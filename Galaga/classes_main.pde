class Galaga
{
  int x, y;
  String sprite[];
  color baseColor = color(255);
  color nextColor = baseColor;

  void draw()
  {
    updateObj();
    drawSprite(x, y);
  }

  void drawSprite(int xpos, int ypos)
  {
    fill(nextColor);

    nextColor = baseColor;

    for (int i = 0; i < sprite.length; i++)
    {
      String row = (String) sprite[i];

      for (int j = 0; j < row.length(); j++)
      {
        if (row.charAt(j) == '1') {
          rect(xpos+(j * pixelsize), ypos+(i * pixelsize), pixelsize, pixelsize);
        }
      }
    }
  }

  void updateObj()
  { }
}

class Player extends Galaga
{
  int vidaPlayer = 10;
  boolean canShoot = true;
  int shootdelay = 0;
  
  Player()
  {
    x = width/gridsize/2;
    y = height - (10 * pixelsize);
    sprite    = new String[10];
    sprite[0] = "000010100000";
    sprite[1] = "000110110000";
    sprite[2] = "000110110000";
    sprite[3] = "001111111010";
    sprite[4] = "011111111110";
    sprite[5] = "011111111100";
    sprite[6] = "011111111100";
    sprite[7] = "011111111100";
    sprite[8] = "001111111000";
    sprite[9] = "000111110000";
  }

  void updateObj()
  {
    if (keyPressed && keyCode == LEFT)
    {
      x -= 6;
      if (player.x < (width/gridsize/2 - 15))
      {
        player.x = (width/gridsize/2 - 15);
      }
    }

    if (keyPressed && keyCode == RIGHT)
    {
      x += 6;
      if (player.x > (width - 45))
      {
        player.x = width - 45;
      }
    }
    
    if (keyPressed && key == 'a')
    {
      x -= 6;
      if (player.x < (width/gridsize/2 - 15))
      {
        player.x = (width/gridsize/2 - 15);
      }
    }

    if (keyPressed && key == 'd')
    {
      x += 6;
      if (player.x > (width - 45))
      {
        player.x = width - 45;
      }
    }

    if (keyPressed && keyCode == UP && canShoot)
    {
      municao.add(new Municao(x, y));
      canShoot = false;
      shootdelay = 0;
    }

    if (mousePressed && canShoot)
    {
      municao.add(new Municao(x, y));
      canShoot = false;
      shootdelay = 0;
    }

    shootdelay++;

    if (shootdelay >= 8)
    {
      canShoot = true;
    }
  }
  
  boolean alive()
  {
    for (int i = 0; i < municaoBoos.size(); i++)
    {
      MunicaoBoss MunicaoBoss = (MunicaoBoss) municaoBoos.get(i);
      if (MunicaoBoss.x > x && MunicaoBoss.x < x + 12 * pixelsize && 
          -MunicaoBoss.y > y && -MunicaoBoss.y < y + 10 * pixelsize)
      {
        municaoBoos.remove(i);
        vidaPlayer--;
        nextColor = color(0, 125, 255);
        if (vidaPlayer == -1)
        {
          return false;
        }
      }
    }
    return true;
  }
}

class Inimigo extends Galaga
{
  int vidaInimigo = 1;

  Inimigo(int xpos, int ypos)
  {
    x = xpos;
    y = ypos;
    sprite    = new String[5];
    sprite[0] = "1011101";
    sprite[1] = "0101010";
    sprite[2] = "1111111";
    sprite[3] = "0101010";
    sprite[4] = "1000001";
  }

  void updateObj()
  {
    if (frameCount % 10 == 0)
    {
      x += direcao * gridsize;
    }

    if (parede == true)
    {
      y += gridsize / 2;
    }
  }
  
  boolean alive()
  {
    for (int i = 0; i < municao.size(); i++)
    {
      Municao Municao = (Municao) municao.get(i);
      if (Municao.x > x && Municao.x < x + 7 * pixelsize + 5 && Municao.y > y && Municao.y < y + 5 * pixelsize)
      {
        municao.remove(i);
        vidaInimigo--;
        nextColor = color(255, 0, 0);
        if (vidaInimigo == 0)
        {
          score += 50;
          return false;
        }
      }
    }
    return true;
  }
  
  boolean outside()
  {
    return x + (direcao*gridsize) < 0 || x + (direcao*gridsize) > width - gridsize;
  }
}

class Boss extends Galaga
{
  int vidaBoss = 25;
  boolean canShoot = true;
  int shootdelay = 0;

  Boss(int xpos, int ypos)
  {
    x = xpos;
    y = ypos + 100;
    sprite     = new String[12];
    sprite[0]  = "000001100000";
    sprite[1]  = "000011110000";
    sprite[2]  = "001111111100";
    sprite[3]  = "001001100100";
    sprite[4]  = "011001100110";
    sprite[5]  = "011001100110";
    sprite[6]  = "011111111110";
    sprite[7]  = "011111111110";
    sprite[8]  = "000110011000";
    sprite[9]  = "000110011000";
    sprite[10] = "011001100110";
    sprite[11] = "110110011011";
 
  }

  void updateObj()
  {
    if (frameCount % 10 == 0)
    {
      x += direcao * gridsize;
    }

    if (canShoot)
    {
      municaoBoos.add(new MunicaoBoss(x, y));
      canShoot = false;
      shootdelay = 0;
    }

    shootdelay++;

    if (shootdelay >= 15)
    {
      canShoot = true;
    }
  }
  
  boolean alive()
  {
    for (int i = 0; i < municao.size(); i++)
    {
      Municao Municao = (Municao) municao.get(i);
      if (Municao.x > x && Municao.x < x + 12 * pixelsize + 5 && Municao.y > y && Municao.y < y + 12 * pixelsize)
      {
        municao.remove(i);
        vidaBoss--;
        nextColor = color(255, 0, 0);
        if (vidaBoss == -1)
        {
          score += 800;
          return false;
        }
      }
    }
    return true;
  }
  
  boolean outside()
  {
    return x + (direcao*gridsize) < 0 || x + (direcao*gridsize) > width - gridsize;
  }
}
