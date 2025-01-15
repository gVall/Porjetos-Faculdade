class Meteorito
{
  void draw()
  {
    int starCount = 50, minSpeed = 2, maxSpeed = 20, cont = 0;
    
    for (int i = 0; i < starCount; i++)
    {
      estrelas.add(new PVector(random(2*width), random(height), random(minSpeed, maxSpeed)));
    }
    
    for (int i = 0; i < starCount; i++)
    {
      if (cont%2 == 0)
      {
        stroke(85, 31, 31);
        strokeWeight(5);
      } 
      else
      {
        stroke(59, 113, 255);
        strokeWeight(8);
      }
      estrelas.set(i, new PVector(estrelas.get(i).x - estrelas.get(i).z, estrelas.get(i).y, estrelas.get(i).z));
      if (estrelas.get(i).x < 0)
      {
        estrelas.set(i, new PVector(random(width, 2*width), random(height), random(minSpeed, maxSpeed)));
      }
      point(estrelas.get(i).x, estrelas.get(i).y);
      cont++;
    }
    cont = 0;
  }
}

void cometa(int cor)
{
  if (cor == 1)
    fill(0, 0, 150);
  if (cor == 2)
    fill(225, 0, 0);
    
  Desloc = frameCount % 100;
  index = (Desloc + Num) % Num;
  
  for (int i = 0; i < Num; i++)
  {
    ellipse(P1*(index+i/5.5)-125, P1*(index+i/5.5)-125, i, i);
  }
  beginShape();
  texture(Img);
  vertex(P1*index, P1*index, 0, 0);
  vertex(P2*index, P1*index, 3, 0);
  vertex(P2*index, P2*index, 3, 3);
  vertex(P1*index, P2*index, 0, 3);
  endShape();
}
