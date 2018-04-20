/**
 * Created with IntelliJ IDEA.
 * User: zhenkondrat
 * Date: 20.04.18
 * Time: 9:47
 * To change this template use File | Settings | File Templates.
 */
public class DataInput {
    String a;
    String b;
    String c;

    Object res;

    public DataInput(String _a, String _b, String _c, Object _res){
        this.a = _a;
        this.b = _b;
        this.c = _c;

        this.res = _res;
    }

    @Override
    public String toString(){
        return "("+this.a+", "+this.b+", "+this.c+")";
    }

    public void outObject(Object obj){
        if (obj==null)
            System.out.println(" null ");
        else
        {
            if(obj.getClass()== String.class)
                return;
            double[] arr = (double[]) obj;
            for(double item : arr)
                System.out.print(item + " ");
            System.out.println();
        }
    }

    public void outObject(){
       this.outObject(this.res);
    }

    public boolean analise(Object obj){
        if (obj==null)
            return this.res==null ? true : false;
        else
            {
                if (this.res.getClass()== String.class)
                    return obj!=null ? true : false;

                double[] res_arr = (double[]) obj;
                double[] goos_arr = (double[]) this.res;
                for(int i=0; i<goos_arr.length;i++)
                    if (res_arr[i]!=goos_arr[i])
                        return false;
                return true;
            }
    }
}
