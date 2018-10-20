package in.brainwired.www.formtest;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FormAdapter adapter;
    private FloatingActionButton btn_add;
    private Button submit_Button,show_Button;
    private List<String> form;
    private Collection<JSONObject> requestArray;
    private JSONObject request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_Button=findViewById(R.id.show_button);
        btn_add=findViewById(R.id.add_button);
        submit_Button=findViewById(R.id.submit_button);
        recyclerView=findViewById(R.id.recycler_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        form = new ArrayList<>();
        requestArray = new ArrayList<JSONObject>();
        adapter= new FormAdapter(this,form);
        recyclerView.setAdapter(adapter);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addItem();
                adapter.notifyDataSetChanged();
            }
        });

        submit_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < adapter.getItemCount(); i++) {
                    TextInputLayout product_name = recyclerView.getLayoutManager().findViewByPosition(i).findViewById(R.id.product_name);
                    TextInputLayout company_id = recyclerView.getLayoutManager().findViewByPosition(i).findViewById(R.id.company_id);
                    String p_name  = product_name.getEditText().getText().toString();
                    String c_id = company_id.getEditText().getText().toString();
                    try {
                        request = new JSONObject();
                        request.put("product_name",p_name);
                        request.put("company_id",c_id);
                        requestArray.add(request);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    // Store et.getText() in your array
                }
            }
        });
        show_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),requestArray.toString(),Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), adapter.getItemCount(),Toast.LENGTH_SHORT).show();

            }
        });


    }
}
