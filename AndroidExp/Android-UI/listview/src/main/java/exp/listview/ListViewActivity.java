package exp.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends Activity {

    private String[] animalsnames=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(exp.listview.R.layout.activity_list_view);

        SimpleAdapter adapter =new SimpleAdapter(this,getData(), exp.listview.R.layout.simpleadapter,new String[]{"animal","img"},new int[]{exp.listview.R.id.animal, exp.listview.R.id.img});

        ListView  list=(ListView)findViewById(exp.listview.R.id.mylist);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),animalsnames[i],Toast.LENGTH_LONG).show();
            }
        });


    }

    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("animal",animalsnames[0]);
        map.put("img", exp.listview.R.drawable.lion);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("animal",animalsnames[1]);
        map.put("img", exp.listview.R.drawable.tiger);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("animal",animalsnames[2]);
        map.put("img", exp.listview.R.drawable.monkey);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("animal",animalsnames[3]);
        map.put("img", exp.listview.R.drawable.dog);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("animal",animalsnames[4]);
        map.put("img", exp.listview.R.drawable.cat);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("animal",animalsnames[5]);
        map.put("img", exp.listview.R.drawable.elephant);
        list.add(map);

        return list;
    }
}
