package com.example.task51;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.task51.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView horizontalRecyclerView;
    RecyclerView.LayoutManager layoutManager;

    RecyclerView.LayoutManager verticalLayoutManager;

    ArrayList<MyDataModel> topStoryList;
    ArrayList<MyDataModel> newsList;

    ArrayList<RelatedDataModel> relatedList;

    HorizontalAdaptor horizontalAdaptor;
    VerticalAdaptor verticalAdaptor;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating binding for using items from view
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //add the data to the data models manually for use in the recyclerviews and fragments.
        relatedList = new ArrayList<>();
        relatedList.add(new RelatedDataModel("Volcanic Eruption in Hawaii", "Hawaii has had a major volcanic eruption with follow up tremors.", "https://cdn.pixabay.com/photo/2017/04/26/10/40/volcano-2262295_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet."));
        relatedList.add(new RelatedDataModel("Intense Storm Over Toronto", "An unexpected summer storm has wreaked havoc over Toronto leaving potentially thousands without power.", "https://cdn.pixabay.com/photo/2019/11/25/12/12/storm-over-belgrade-4651872_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet cursus sit amet dictum sit amet justo. Pellentesque nec nam aliquam sem et. Egestas maecenas pharetra convallis posuere morbi leo. Euismod in pellentesque massa placerat duis ultricies. Velit aliquet sagittis id consectetur purus ut faucibus pulvinar. Sociis natoque penatibus et magnis dis parturient montes nascetur. Maecenas pharetra convallis posuere morbi leo urna molestie. Integer quis auctor elit sed vulputate mi sit amet. Metus aliquam eleifend mi in. Pellentesque habitant morbi tristique senectus. Ipsum consequat nisl vel pretium lectus quam id. At quis risus sed vulputate odio ut enim. Sed viverra ipsum nunc aliquet. Odio ut sem nulla pharetra diam sit. Feugiat vivamus at augue eget arcu dictum varius duis at. Viverra orci sagittis eu volutpat odio facilisis mauris sit.\n" +
                "\n" +
                "Penatibus et magnis dis parturient montes nascetur ridiculus mus. Dictum varius duis at consectetur lorem. Nunc vel risus commodo viverra maecenas accumsan. Feugiat sed lectus vestibulum mattis ullamcorper velit sed. Quis varius quam quisque id diam vel quam. Ac turpis egestas integer eget aliquet nibh praesent tristique. In metus vulputate eu scelerisque felis imperdiet. Fusce id velit ut tortor pretium viverra. Vel fringilla est ullamcorper eget nulla facilisi. Auctor eu augue ut lectus arcu bibendum at. Diam in arcu cursus euismod quis viverra nibh cras. Iaculis eu non diam phasellus vestibulum lorem. Viverra vitae congue eu consequat ac. Aliquam ultrices sagittis orci a scelerisque. Sagittis nisl rhoncus mattis rhoncus urna neque viverra. Proin sed libero enim sed."));


        topStoryList = new ArrayList<>();
        topStoryList.add(new MyDataModel("New Climate Impact to Glaciers", "Scientists have recently discovered glaciers in northern Netherlands have been degrading faster than first estimated.", "https://cdn.pixabay.com/photo/2014/12/29/23/30/glacier-583419_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));
        topStoryList.add(new MyDataModel("Infrastructure Not Meeting Demand", "test description", "https://cdn.pixabay.com/photo/2014/04/27/00/43/traffic-332857_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));
        topStoryList.add(new MyDataModel("Germany to Remove Nuclear Energy", "test description", "https://cdn.pixabay.com/photo/2017/07/02/00/42/bundestag-2463231_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));
        topStoryList.add(new MyDataModel("Swimming Doping Scandal", "test description", "https://cdn.pixabay.com/photo/2013/02/09/04/23/swimmers-79592_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));
        topStoryList.add(new MyDataModel("Incoming Housing Market Crash", "test description", "https://cdn.pixabay.com/photo/2016/11/18/17/46/house-1836070_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));

        newsList = new ArrayList<>();
        newsList.add(new MyDataModel("How Olive Oil May Change Your Life", "Can adding olive oil to each meal really lower your cholesterol?", "https://cdn.pixabay.com/photo/2015/10/02/15/59/olive-oil-968657_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));
        newsList.add(new MyDataModel("Apple Stocks Continue to Rise", "Despite a poor reveal of the iPhone 50, Apple has had another surge in stock prices.", "https://cdn.pixabay.com/photo/2017/08/10/01/42/stock-market-2616931_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));
        newsList.add(new MyDataModel("Volcanic Eruption in Hawaii", "Hawaii has had a major volcanic eruption with follow up tremors.", "https://cdn.pixabay.com/photo/2017/04/26/10/40/volcano-2262295_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));
        newsList.add(new MyDataModel("Crime Investigate in North Melbourne", "A major drug bust has results in mass arrests in Melbourne's northern suburbs.", "https://cdn.pixabay.com/photo/2021/11/27/16/23/cars-6828443_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));
        newsList.add(new MyDataModel("New French Minister for Finance", "A new finance minister in France has been sworn in after the sudden resignation of Julian Houso.", "https://cdn.pixabay.com/photo/2018/04/03/21/24/meeting-3288133_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));
        newsList.add(new MyDataModel("New Breakthrough in Cancer Research", "Another step closer towards skin cancer elimination has been discovered with the help of Wombats.", "https://cdn.pixabay.com/photo/2017/10/04/09/56/laboratory-2815641_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mi quis hendrerit dolor magna eget est lorem. Convallis convallis tellus id interdum velit laoreet id. Arcu non odio euismod lacinia at quis risus sed vulputate. Feugiat in ante metus dictum at. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero. In est ante in nibh. Congue nisi vitae suscipit tellus mauris a. Scelerisque eleifend donec pretium vulputate sapien nec sagittis. Ante in nibh mauris cursus mattis molestie a. Enim neque volutpat ac tincidunt. Porttitor leo a diam sollicitudin. Duis at consectetur lorem donec massa. Magna fermentum iaculis eu non. Turpis massa sed elementum tempus egestas sed sed. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Et leo duis ut diam quam nulla. Malesuada nunc vel risus commodo viverra maecenas. At urna condimentum mattis pellentesque. Id faucibus nisl tincidunt eget.\n" +
                "\n" +
                "Vitae auctor eu augue ut lectus arcu bibendum at varius. Nunc faucibus a pellentesque sit amet porttitor eget. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Venenatis cras sed felis eget velit. Volutpat ac tincidunt vitae semper quis lectus nulla at. Nunc sed augue lacus viverra vitae congue eu. Risus nec feugiat in fermentum posuere urna nec tincidunt praesent. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Turpis tincidunt id aliquet risus feugiat in ante. Habitant morbi tristique senectus et netus. Vel fringilla est ullamcorper eget. Neque volutpat ac tincidunt vitae. Sodales ut etiam sit amet nisl purus in. Sed augue lacus viverra vitae congue eu consequat ac felis. Faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque.\n" +
                "\n" +
                "Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Laoreet non curabitur gravida arcu ac tortor dignissim convallis. Felis eget nunc lobortis mattis aliquam faucibus purus in. Nisl rhoncus mattis rhoncus urna neque viverra justo nec. Facilisi nullam vehicula ipsum a arcu. Sit amet purus gravida quis. Pellentesque massa placerat duis ultricies lacus. Enim ut tellus elementum sagittis vitae et leo duis ut. Duis at tellus at urna condimentum mattis. Tempor id eu nisl nunc mi ipsum faucibus vitae aliquet.",
                relatedList));


        //setting up the layoutmanagers and adaptors for the two recyclerviews on the main activity
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        verticalLayoutManager = new LinearLayoutManager(this);

        horizontalAdaptor = new HorizontalAdaptor(this, topStoryList);
        verticalAdaptor = new VerticalAdaptor(this, newsList);


        binding.horizontalRecyclerView.setAdapter(horizontalAdaptor);
        binding.horizontalRecyclerView.setLayoutManager(layoutManager);
        binding.verticalRecyclerView.setAdapter(verticalAdaptor);
        binding.verticalRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

    }
}