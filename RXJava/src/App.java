import java.util.function.Consumer;


import rx.*;
import rx.functions.Action1;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hello("Tom","Jan");
		
		
		 // defining the source
		Observable<Integer> source = Observable.range(1, 5);
		Observable<Integer> source2 = Observable.range(10,20);
		
		
		// defining the consumer
		Subscriber<Integer> consumer = new Subscriber<Integer>() {
			    @Override
			    public void onNext(Integer number) { System.out.println("Got number: "+number); }
			    @Override
				public void onError(Throwable e) { System.out.println("error"); }

				@Override
				public void onCompleted() { System.out.println("completed"); }
		};
		
		
		// connecting the consumer to source
		source.subscribe(consumer);
		
		// Sour
		source2.subscribe(consumer);
		
		
		Flowable.just("Hello world")
		  .subscribe(new Consumer<String>() {
		      @Override public void accept(String s) {
		          System.out.println(s);
		      }
		  });

		

	}
	
	
	public static void hello(String... names) {
	    Observable.from(names).subscribe(new Action1<String>() {

	        @Override
	        public void call(String s) {
	            System.out.println("Hello " + s + "!");
	        }

	    });
	}
	
	

	

}
