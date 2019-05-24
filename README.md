# InfinteAutoList
Library help to make recycler view easy by providing extended feature on recycler like auto scroll with loop sliders.

### Prerequisites
SDK should be greater than 16.
Library works on RecyclerView so you need to put recycler dependency in your project.

### Installing
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.Rayspro:InfinteAutoList:$LATEST_VERSION'
	}
  
Step 3.Now you ready to go.  

Step 4.Create a adapter inherite InfiniteAutoListAdapter and override the all method.

Step 5.Create a object of InfiniteAutoList object and Adapter object in you main class.

Step 6.After the simply call init() method.

### Extra customize

init() : to start Adapter.
setDelayTime(3000L): set Delay Time.
setTouchwait(9000L):set Touch Time.
Remember always call both method after init call.

### Example

	public class OfferView extends InfiniteAutoListAdapter {
	    private ArrayList<Type_of_array> arraylist;
	    private Context context;
	    public OfferView(Context context, ArrayList arrayList) {
		super(context, arrayList);
		//initialize your arraylist and context here
	    }
	    @Override
	    public int onSetView() {
		//return your own layout
		//return R.layout.slide2;
	    }
	    @Override
	    public void onBindView(Holder holder, int actual_position) {
	    //get your item via holder.item.findViewById(...)
	    //play with your component
	    }
	}

#### In your main activity..

	OfferView offerView=new OfferView(getContext(),Arraylist);
	InfiniteAutoList infiniteAutoList=new InfiniteAutoList(context,RecyclerView_id rec,offerView);
	infiniteAutoList.init();
	.........
## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
