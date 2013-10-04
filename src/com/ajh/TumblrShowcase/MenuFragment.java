package com.ajh.TumblrShowcase;

import android.app.Fragment;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: thedirtycalvinist
 * Date: 10/3/13
 * Time: 7:21 PM
 * Copyright 2013 Aaron Haser
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class MenuFragment extends Fragment {

    private ListView list;
    private AdapterView.OnItemClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_list, container, false);
        list = (ListView) mainView.findViewById(R.id.listView);
        list.setAdapter(new TumblrAdapter(getActivity(), TumblrBlog.tumblrs));
        if(listener != null)
            list.setOnItemClickListener(listener);
        return mainView;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener){
        this.listener = listener;
        if(list != null)
            list.setOnItemClickListener(listener);
    }

    private class TumblrAdapter implements ListAdapter {

        private TumblrBlog[] tumblrs;
        private LayoutInflater inflater;

        public TumblrAdapter(Context ctxt, TumblrBlog[] tumblrBlogs)
        {
            tumblrs = tumblrBlogs;
            inflater = LayoutInflater.from(ctxt);
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public boolean isEnabled(int position) {
            return true;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return tumblrs.length;
        }

        @Override
        public Object getItem(int position) {
            if(position >= tumblrs.length)
                return null;
            else
                return tumblrs[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        private class ViewHolder {
            TextView title;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.item_menu, parent, false);
                holder = new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.title);
                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.title.setText(((TumblrBlog) getItem(position)).getTitle());
            return convertView;
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return tumblrs.length == 0;
        }
    }

}
