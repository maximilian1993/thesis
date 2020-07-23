abstract sig Id {}
sig Address extends Id {}
sig Alias extends Id {
	refers: set Id
}

sig Target {
	include: set Id,
	exclude: set Id
}

sig Message {
	to: Target
}

fact {
	no a: Alias | a in a.^refers
}

fun diffThenRefers[t: Target]: set Id {
	t.(include - exclude).*refers - Alias
}


fun refersThenDiff[t: Target]: set Id {
	(t.include.*refers - t.exclude.*refers) - Alias
}

assert OrderIrrelevant {
	all t: Target | diffThenRefers[t] = refersThenDiff[t]
}

check OrderIrrelevant

pred example {}

run example for 5
