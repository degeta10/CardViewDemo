package in.brainwired.www.formtest;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.MyViewHolder> {

    public Context mCtx;
    public List<String> myList;

    public FormAdapter(Context mCtx, List<String> myList) {
        this.mCtx = mCtx;
        this.myList = myList;
    }

    public void addItem() {
        myList.add(new String());
        notifyItemInserted(myList.size() - 1);
    }

    @Override
    public FormAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.form_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FormAdapter.MyViewHolder holder, int position) {
        // bind your view
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextInputLayout product_name,company_id;
        Button btn_remove;

        public MyViewHolder(View itemView) {
            super(itemView);
            product_name = itemView.findViewById(R.id.product_name);
            company_id = itemView.findViewById(R.id.company_id);
            btn_remove = itemView.findViewById(R.id.remove_button);

            btn_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(), myList.size());
                }
            });
        }
    }
}