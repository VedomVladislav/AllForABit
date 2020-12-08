package flappyBird

import java.io._;
import java.io.IOException;
import java.io.RandomAccessFile;

class lr5 {

  def sort(xs: Array[Long], xsi :Array[Int]) {
  def swap(i: Int, j: Int) {
    val t = xs(i);
    xs(i) = xs(j);
    xs(j) = t
  }
  def swapi(i: Int, j: Int) {
    val t = xsi(i);
    xsi(i) = xsi(j);
    xsi(j) = t
  } 
  def sort1(l: Int, r: Int) {
    val pivot = xs((l + r) / 2)
    var i = l;
    var j = r
    while (i <= j) {
      while (xs(i) < pivot) i += 1
      while (xs(j) > pivot) j -= 1
      if (i <= j) {
        swap(i, j)
        swapi(i,j)
        i += 1
        j -= 1
      }
    }
    if (l < j) sort1(l, j)
    if (j < r) sort1(i, r)
  }
  sort1(0, xs.length - 1)
}

def main1(): Unit = {
  var i=0;
  var xs : Array[Long] = new Array[Long](10000);
  var xsi : Array[Int] = new Array[Int](10000)
  var timeout : Long = System.currentTimeMillis();
  while (i < 10000){
    val ReplayFileStream: RandomAccessFile = new RandomAccessFile("SaveGame"+Integer.toString(i)+".fb1", "rw");
    xsi(i)=i;
    i=i+1;
    val n: Long = ReplayFileStream.readLong();
    var j: Int = 0;
    var s: Long = 0;
    while (j<n){ s=s+ReplayFileStream.readLong(); j=j+1;}
    xs(i)=s;
  }
  
  i=0;
  sort(xs,xsi)
  i = 0;
  var fos_step : FileOutputStream = new FileOutputStream("savedarr_sorted_scala.txt");
  var outStream_step : ObjectOutputStream = new ObjectOutputStream(fos_step);
  while ( i < 10000) {
      outStream_step.writeChars(Integer.toString(xsi(i))+", "); 
      i = i+1;
  }
  outStream_step.close();
  timeout = System.currentTimeMillis() - timeout;
  System.out.print(" Scala QS:");
                System.out.print(timeout);
}
}