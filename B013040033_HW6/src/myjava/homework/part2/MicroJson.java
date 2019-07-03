package myjava.homework.part2;



import java.lang.reflect.Field;

public class MicroJson<T>{
    //Get variable type string using: getType(field)
    //Get variable name string using: getName(field)
    //Get variable value string using: field.get(target)

    public String serialize(T target){
        StringBuilder result = new StringBuilder("{");
        //Fields is the collection of all variable in target
        /**getDeclaredFields() 反射獲取對象成員的字段值
         * (此函式只能獲取自己聲名的各種字段 ex public,private,protected )
        **/
        Field[] fields = target.getClass().getDeclaredFields();
        /**getClass()
         * 回傳  classname.class 
         * ex Test.class
         * **/
        int len =fields.length;
        //out.printf("len=%d:\n",len);
        for(int i=0;i<len;i++)
        {
	        try {
	            /** Example : Get information of first variable*/
	        	boolean st_flag=false;
	        	
	        	if (getType(fields[i]).equals("String"))
	        		st_flag=true;
	        	
	            result.append("\""+ getName(fields[i]) +"\"");
	            result.append(":");
	            if(st_flag)
	            	result.append("\"");
	            result.append(fields[i].get(target) );
	            if(st_flag)
	            	result.append("\"");
	            if(i!=len-1)
	            	result.append(",");
	        } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        }
        }
        result.append("}");
        return result.toString();
    }

    public String getType(Field field){
        return (field.getType()).getSimpleName();
    }
    public String getName(Field field){
        return field.getName();
    }
}
