package com.suvilai.ex5.fragments

/*
private lateinit var binding: CommentFragmentBinding
private lateinit var adapter: CommentListAdapter

class CommentFragment : Fragment() {

    private val args by navArgs<CommentFragmentArgs>()
    private val commentViewModel : CommentViewModel by viewModels {
        CommentViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.comment_fragment,container,false)

        adapter = commentViewModel.adapter
        val recyclerView = binding.commentRecycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        commentViewModel.getSelectedCommentsLiveData().distinctUntilChanged().observe(viewLifecycleOwner) {
            this.commentRecycler.layoutManager = LinearLayoutManager(requireContext())
            this.commentRecycler.adapter = CommentListAdapter()
        }

        return binding.root
    }

    override fun onSendCommentButtonClicked(v: View?) {
        if (binding.editComment.text.isEmpty()) {
            return
        } else {
            commentViewModel.createComment(args.hetekaId, binding.editComment.text.toString()) {
                binding.
            }
        }
    }
}

 */