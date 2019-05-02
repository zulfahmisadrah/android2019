package com.zulfahmi.kuliahlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Hero> heroes;

    public HeroAdapter(Context context) {
        this.context = context;
        heroes = new ArrayList<>();
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return heroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Hero hero = (Hero) getItem(position);
        viewHolder.bind(hero);
        return view;
    }

    private class ViewHolder{
        private TextView  tvName, tvDesc;
        private ImageView imgHero;

        private ViewHolder(View view) {
            tvName = view.findViewById(R.id.txt_name);
            tvDesc = view.findViewById(R.id.txt_description);
            imgHero = view.findViewById(R.id.img_photo);
        }

        void bind(Hero hero){
            tvName.setText(hero.getName());
            tvDesc.setText(hero.getDesc());
            imgHero.setImageResource(hero.getPhoto());
        }
    }
}
