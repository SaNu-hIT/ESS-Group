package glog.leeway.com.home_page.Customfont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class MyAutoComplete extends android.support.v7.widget.AppCompatAutoCompleteTextView
{
  public MyAutoComplete(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public MyAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public MyAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    if (!isInEditMode())
      setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/MavenPro-Regular.ttf"));
  }
}

