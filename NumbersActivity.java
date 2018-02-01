package eyup.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;




    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {

            releaseMediaPlayer();//Ses dosyası oynatılamadığına göre, medya oynatıcı kaynaklarını bırakın.
        }
    };



    @Override
    protected void onStop() { //Uygulama home tuşuna basıldğında ses kesilir
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        final ArrayList<Word> words = new ArrayList<Word>(); //Wordde ne belirttiysek aşağadaki kısımları doldurcaz

        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one)); //isim,çevirisi,resim,ses
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers); //Adapteri arraylist ile bağla

        final ListView listView = (ListView) findViewById(R.id.list); //Sonra listview belirt

        listView.setAdapter(adapter);//ve adapterdeki verileri orda göster

        //AdapterViewda tıklama şekli Listview için geçerli ItemClik
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word word = words.get(position); // İlkten sona kadar listedeki değerler pozisyonlar
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId()); //getMAudıoResource a gidicek ses belirtildi mi diye yukarde belirttiğimiz sesler çalıncak
                mMediaPlayer.start();//Ve başlatılcak tıklandığında


                mMediaPlayer.setOnCompletionListener(mCompletionListener);

                //********

            }
        });
    }
    private void releaseMediaPlayer(){
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release(); //bırakır yani başka sese tıklandığı zaman sesi keser direk

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }

    }
}


