package com.cmpe451.eatalyze.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.cmpe451.eatalyze.R;
import com.cmpe451.eatalyze.models.Ingredient;

import java.util.ArrayList;
import java.util.StringTokenizer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Behiye on 11/19/2016.
 */

public class IngredientAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;

    ArrayList<Ingredient> ingredientList;

    public IngredientAdapter(Context context, ArrayList<Ingredient> mealList) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.ingredientList = mealList;
    }

    @Override
    public int getCount() {
        if (ingredientList != null) {
            return ingredientList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return ingredientList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ingredientList.indexOf(ingredientList.get(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_ingredient, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else holder = (ViewHolder) view.getTag();

        Ingredient ingredient = ingredientList.get(i);
        holder.etIndgredient.setText(ingredient.getName());
        holder.etAmount.setText(Double.toString(ingredient.getAmount()));

        return view;
    }


    static class ViewHolder {
        @Bind(R.id.et_indgredient)
        EditText etIndgredient;
        @Bind(R.id.et_amount)
        EditText etAmount;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
