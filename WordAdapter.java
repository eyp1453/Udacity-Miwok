package eyup.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words,int colorResourceId) { //önce constructor
        super(context , 0 , words);
        mColorResourceId = colorResourceId; //***

    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) { //sonra getview metodu gelir burası daha önemli :)

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent , false); //List item layoutu içinde olcak herşey ınflater ile taşıdık aslında
        }
        Word currentWord = getItem(position); //Worddeki değerleri settexte belirler aslında

        TextView miwokTextView = (TextView)listItemView.findViewById(R.id.miwok_text_view); //ilk metin
        miwokTextView.setText(currentWord.getmMiwokTranslotion());

        TextView defaultTextView = (TextView)listItemView.findViewById(R.id.default_text_view); // İkincil metini belirledik
        defaultTextView.setText(currentWord.getmDefaultTranslatiom());

        ImageView iconView = (ImageView)listItemView.findViewById(R.id.icon_list); // İcon resmimiz

        //***


        //Eğer resim varsa
        if (currentWord.hasImage()){

            iconView.setImageResource(currentWord.getmImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        } else { // Yoksa gösterme
            iconView.setVisibility(View.GONE);
        }
        //******

        //Her liste için arkaplan
        View textContainer =  listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(),mColorResourceId);

        textContainer.setBackgroundColor(color);
        //****


        return listItemView;//geri döndür


    }
}
