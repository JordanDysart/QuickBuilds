package com.ogokilearning.libraryquickbuild;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CategoryFragment extends BaseFragment implements CategoryAdapter.CategoryClickListener {

	RecyclerView recyclerView;

	public CategoryFragment() {
		//Blank Constructor
	}

	@Override
	public void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			getActivity().getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
		}

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		if (container == null) {
			return null;
		}
		View view = inflater.inflate(R.layout.fragment_category_screen, container, false);
		recyclerView = view.findViewById(R.id.recyclerview_categories);
		Context context = getContext();
		AutofitLayoutManager linearLayoutManager = new AutofitLayoutManager(context, 365);
		CategoryAdapter adapter = new CategoryAdapter(this);
		recyclerView.setLayoutManager(linearLayoutManager);
		recyclerView.setAdapter(adapter);

		return view;
	}

	@Override
	public void onDetach() {
		super.onDetach();

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();

	}

	@Override
	public void onItemClick(int clickedItemIndex) {
		String categoryTitle = getCategoryTitle(clickedItemIndex);
		fragmentTabActivity.addFragments(categoryTitle, LanguageFragment.newInstance(clickedItemIndex), true, true);
		fragmentTabActivity.setBackground(categoryTitle);
	}

	public String getCategoryTitle(int index) {
		String[] categories = Dictionary.getGridCategories();
		return categories[index];
	}

}
